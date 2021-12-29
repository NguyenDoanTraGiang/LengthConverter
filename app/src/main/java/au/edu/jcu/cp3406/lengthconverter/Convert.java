package au.edu.jcu.cp3406.lengthconverter;

import java.util.Hashtable;

public class Convert {

  public static Hashtable<String, Double> toMeters() {
    Hashtable<String, Double> toMeters = new Hashtable<>();
    toMeters.put("Millimeter", 0.001);  //one mm is equals to 0.001 meter
    toMeters.put("Centimeter", 0.01);
    toMeters.put("Kilometre", 1000.0);
    toMeters.put("Foot", 0.3048);
    toMeters.put("Yard", 0.9144);
    toMeters.put("Mile", 1609.34);
    toMeters.put("Meter", 1.0);
    return toMeters;
  }

  static double calculation(String fromUnit, String toUnit, double amount) {
    return amount * toMeters().get(fromUnit) * 1 / (toMeters().get(toUnit));
  }
}

