package model;

import java.util.List;
import java.util.Map;

public record Cotacao (Map<String, Double> conversion_rates) {
}
