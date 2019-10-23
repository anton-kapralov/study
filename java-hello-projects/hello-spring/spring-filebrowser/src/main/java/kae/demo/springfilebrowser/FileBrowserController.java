package kae.demo.springfilebrowser;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Comparator;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

/** */
@Controller
public class FileBrowserController {

  private final String root;

  public FileBrowserController(@Value("${browsing.rootpath}") String root) {
    this.root = root;
  }

  @GetMapping("/**")
  public String getDirectoryPage(HttpServletRequest request, Model model) {
    String normalizedPath = request.getRequestURI().trim().replaceAll("\\.\\.", "");

    File file = new File(root + normalizedPath);

    if (!file.exists()) {
      throw new ResponseStatusException(NOT_FOUND, "File not found: " + normalizedPath);
    }

    if (file.isDirectory()) {
      model.addAttribute("parent", parentOf(normalizedPath));
      model.addAttribute(
          "path", normalizedPath.endsWith("/") ? normalizedPath : normalizedPath + "/");
      File[] children = file.listFiles();
      Arrays.sort(
          children,
          Comparator.comparing(File::isDirectory).reversed().thenComparing(File::getName));
      model.addAttribute("files", children);

      return "index";
    }

    if (file.getName().endsWith(".txt")) {
      try {
        model.addAttribute("content", new String(Files.readAllBytes(file.toPath())));
      } catch (IOException e) {
        model.addAttribute("content", e.getMessage());
      }
    } else {
      model.addAttribute("content", "<Binary data>");
    }

    return "content";
  }

  private String parentOf(String normalizedPath) {
    String parent = normalizedPath.substring(
        0,
        normalizedPath.endsWith("/")
            ? normalizedPath.lastIndexOf('/', normalizedPath.length() - 1)
            : normalizedPath.lastIndexOf('/'));
    return parent.isEmpty() ? "/" : parent;
  }
}
