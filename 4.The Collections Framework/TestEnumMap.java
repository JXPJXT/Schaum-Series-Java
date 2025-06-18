import java.util.Collections;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.EnumMap;

public class TestEnumMap {
    public static void main(String[] args) {
        Map<EuCodes, Country> eu = new EnumMap<EuCodes, Country>(EuCodes.class);
        eu.put(EuCodes.AT, new Country("Austria", "German", 83870, 8192880, 40.9));
        eu.put(EuCodes.PL, new Country("Poland", "Polish", 312685, 38536869, 37.0));
        eu.put(EuCodes.FR, new Country("France", "French", 547030, 60876136, 39.1));
        eu.put(EuCodes.DE, new Country("Germany", "German", 357021, 82422299, 42.6));
        eu.put(EuCodes.IT, new Country("Italy", "Italian", 301230, 58133509, 42.2));
        eu.put(EuCodes.PT, new Country("Portugal", "Portuguese", 92391, 10605870, 38.5));
        eu.put(EuCodes.SE, new Country("Sweden", "Swedish", 449964, 9016596, 40.9));

        System.out.println(eu.size());
        System.out.println(eu.keySet());
        System.out.println(eu.get(EuCodes.PL));
        System.out.println(eu.get(EuCodes.DE));
    }
}

enum EuCodes {
    AM, AT, BY, BE, BG, HR, CY, CZ, DK, EE, FI, FR, GE,
    DE, GR, HU, IS, IE, IT, LV, LI, LT, LU, MK, MT, MD, MC, NL,
    NO, PL, PT, RO, RU, SK, SI, ES, SE, CH, TR, UA, GB, VA
}

class Country {
    private String name;
    private String language;
    private int area;
    private int population;
    private double avAge;

    Country(String name, String lang, int area, int pop, double avAge) {
        this.name = name;
        this.language = lang;
        this.area = area;
        this.population = pop;
        this.avAge = avAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", area=" + area +
                ", population=" + population +
                ", avAge=" + avAge +
                '}';
    }
}