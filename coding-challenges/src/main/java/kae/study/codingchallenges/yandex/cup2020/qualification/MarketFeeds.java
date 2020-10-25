package kae.study.codingchallenges.yandex.cup2020.qualification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

class Offer implements Comparable<Offer> {
  private final String offerId;
  private final int marketSku;
  private final int price;

  Offer(String offerId, int marketSku, int price) {
    this.offerId = offerId;
    this.marketSku = marketSku;
    this.price = price;
  }

  public String offerId() {
    return offerId;
  }

  public int marketSku() {
    return marketSku;
  }

  public int price() {
    return price;
  }

  @Override
  public int compareTo(Offer o) {
    int r = Integer.compare(price, o.price);
    if (r != 0) {
      return r;
    }
    return offerId.compareTo(o.offerId);
  }
}

/** */
public class MarketFeeds {

  public static void main(String[] args) throws IOException, ParseException {
    try (Scanner scanner = getScanner(args);
        PrintWriter writer = getWriter(args)) {
      int n = scanner.nextInt();
      int m = scanner.nextInt();
      scanner.nextLine();

      Map<String, Offer> offersMap = new HashMap<>();
      for (int i = 0; i < n; i++) {
        List<Offer> offers = parse(scanner.nextLine());
        for (Offer offer : offers) {
          offersMap.put(offer.offerId(), offer);
        }
      }

      Collection<Offer> values = offersMap.values();
      Offer[] offers = values.toArray(new Offer[0]);
      Arrays.sort(offers);
      int limit = Math.min(offers.length, m);
      JSONArray jsonArray = new JSONArray();
      for (int i = 0; i < limit; i++) {
        jsonArray.add(toJsonObject(offers[i]));
      }

      JSONObject jsonObject = new JSONObject();
      jsonObject.put("offers", jsonArray);
      jsonObject.writeJSONString(writer);
    }
  }

  private static List<Offer> parse(String s) throws ParseException {
    JSONArray jsonArray = (JSONArray) ((JSONObject) new JSONParser().parse(s)).get("offers");
    List<Offer> offers = new ArrayList<>(jsonArray.size());
    for (Object o : jsonArray) {
      JSONObject jsonObject = (JSONObject) o;
      offers.add(
          new Offer(
              (String) jsonObject.get("offer_id"),
              ((Long) jsonObject.get("market_sku")).intValue(),
              ((Long) jsonObject.get("price")).intValue()));
    }
    return offers;
  }

  private static JSONObject toJsonObject(Offer offer) {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("offer_id", offer.offerId());
    jsonObject.put("market_sku", offer.marketSku());
    jsonObject.put("price", offer.price());
    return jsonObject;
  }

  private static Scanner getScanner(String[] args) throws IOException {
    return args.length > 0 ? new Scanner(Paths.get(args[0])) : new Scanner(System.in);
  }

  private static PrintWriter getWriter(String[] args) throws FileNotFoundException {
    return args.length > 1
        ? new PrintWriter(new OutputStreamWriter(new FileOutputStream(args[1])))
        : new PrintWriter(System.out);
  }
}
