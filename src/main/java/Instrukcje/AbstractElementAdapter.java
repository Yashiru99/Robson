package Instrukcje;

import Instrukcje.Dwuargumentowe.Porównawcze.*;
import com.google.gson.*;
import wyjatki.BladWykonania;

import java.lang.reflect.Type;

public class AbstractElementAdapter implements JsonDeserializer<Wyrazenie> {
    @Override
    public Wyrazenie deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String typ = jsonObject.get("typ").getAsString();
        try {
            switch (typ) {
                case "Blok":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "If":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "While":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "Przypisanie":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "Plus":
                    return context.deserialize(json, Class.forName("Instrukcje.Dwuargumentowe.Liczebne." + typ));
                case "Minus":
                    return context.deserialize(json, Class.forName("Instrukcje.Dwuargumentowe.Liczebne." + typ));
                case "Razy":
                    return context.deserialize(json, Class.forName("Instrukcje.Dwuargumentowe.Liczebne." + typ));
                case "Dzielenie":
                    return context.deserialize(json, Class.forName("Instrukcje.Dwuargumentowe.Liczebne." + typ));
                case "Liczba":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "Zmienna":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "True":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "False":
                    return context.deserialize(json, Class.forName("Instrukcje." + typ));
                case "<":
                    return context.deserialize(json, Mniejsze.class);
                case "<=":
                    return context.deserialize(json, MniejszeRowne.class);
                case ">":
                    return context.deserialize(json, Wieksze.class);
                case ">=":
                    return context.deserialize(json, WiekszeRowne.class);
                case "==":
                    return context.deserialize(json, Rowne.class);
                case "And":
                    return context.deserialize(json, Class.forName("Instrukcje.Dwuargumentowe.WyrazeniaLogiczne" + typ));
                case "Or":
                    return context.deserialize(json, Class.forName("Instrukcje.Dwuargumentowe.WyrazeniaLogiczne" + typ));
                default:
                        throw new BladWykonania("Nieprawidłowy blok");
            }
        }
        catch (BladWykonania | ClassNotFoundException bladWykonania) {
            bladWykonania.printStackTrace();
        }
        return null;
    }
}
