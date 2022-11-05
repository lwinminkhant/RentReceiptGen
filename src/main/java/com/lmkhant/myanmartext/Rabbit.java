package com.lmkhant.myanmartext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Rabbit {
    public Rabbit() {
    }

    public static String uni2zg(String input) {
        String rule = "[ { \"from\": \"င်္\", \"to\": \"ၤ\" }, { \"from\": \"္တွ\", \"to\": \"႖\" }, { \"from\": \"ါ်\", \"to\": \"ၚ\" }, { \"from\": \"ဋ္ဌ\", \"to\": \"႒\" }, { \"from\": \"ိံ\", \"to\": \"ႎ\" }, { \"from\": \"၎င်း\", \"to\": \"၎\" }, { \"from\": \"[ဥဉ](?=[္ုူ])\", \"to\": \"ၪ\" }, { \"from\": \"[ဥဉ](?=[့]?[်])\", \"to\": \"ဥ\" }, { \"from\": \"ည(?=[္ွ])\", \"to\": \"ၫ\" }, { \"from\": \"(္[က-အ])(ိ){0,1}ု\", \"to\": \"$1$2ဳ\" }, { \"from\": \"(္[က-အ])ူ\", \"to\": \"$1ဴ\" }, { \"from\": \"န(?=[ိီ]?[ူွှု္])\", \"to\": \"ႏ\" }, { \"from\" : \"နြ\", \"to\" : \"ႏြ\" }, { \"from\": \"္က\", \"to\": \"ၠ\" }, { \"from\": \"္ခ\", \"to\": \"ၡ\" }, { \"from\": \"္ဂ\", \"to\": \"ၢ\" }, { \"from\": \"္ဃ\", \"to\": \"ၣ\" }, { \"from\": \"္စ\", \"to\": \"ၥ\" }, { \"from\": \"္ဆ\", \"to\": \"ၦ\" }, { \"from\": \"္ဇ\", \"to\": \"ၨ\" }, { \"from\": \"္ဈ\", \"to\": \"ၩ\" }, { \"from\": \"္ဋ\", \"to\": \"ၬ\" }, { \"from\": \"္ဌ\", \"to\": \"ၭ\" }, { \"from\": \"ဍ္ဍ\", \"to\": \"ၮ\" }, { \"from\": \"ဎ္ဍ\", \"to\": \"ၯ\" }, { \"from\": \"္ဏ\", \"to\": \"ၰ\" }, { \"from\": \"္တ\", \"to\": \"ၱ\" }, { \"from\": \"္ထ\", \"to\": \"ၳ\" }, { \"from\": \"္ဒ\", \"to\": \"ၵ\" }, { \"from\": \"္ဓ\", \"to\": \"ၶ\" }, { \"from\": \"္[နႏ]\", \"to\": \"ၷ\" }, { \"from\": \"္ပ\", \"to\": \"ၸ\" }, { \"from\": \"္ဖ\", \"to\": \"ၹ\" }, { \"from\": \"္ဗ\", \"to\": \"ၺ\" }, { \"from\": \"္ဘ\", \"to\": \"ၻ\" }, { \"from\": \"္မ\", \"to\": \"ၼ\" }, { \"from\": \"္လ\", \"to\": \"ႅ\" }, { \"from\": \"ဿ\", \"to\": \"ႆ\" }, { \"from\": \"ွှ\", \"to\": \"ႊ\" }, { \"from\": \"(ၤ)([က-အ])([ျြ]?)ိ\", \"to\": \"$2$3ႋ\" }, { \"from\": \"(ၤ)([က-အ])([ျြ]?)ီ\", \"to\": \"$2$3ႌ\" }, { \"from\": \"(ၤ)([က-အ])([ျြ]?)ံ\", \"to\": \"$2$3ႍ\" }, { \"from\": \"(ၤ)([က-အ])([ျြ]?)([ေ]?)\", \"to\": \"$2$3$4$1\" }, { \"from\": \"ရ(?=([ိီ]?)[ုူွႊ])\", \"to\": \"႐\" }, { \"from\": \"ဏ္ဍ\", \"to\": \"႑\" }, { \"from\": \"ဋ္ဋ\", \"to\": \"႗\" }, { \"from\": \"([က-အႏဩ႐])([ၠ-ၩၬၭၰ-ၼႅႊ])?([ျ-ှ]*)?ေ\", \"to\": \"ေ$1$2$3\" }, { \"from\": \"ြှ\", \"to\": \"ြႇ\" }, { \"from\": \"([က-အႏဩ])([ၠ-ၩၬၭၰ-ၼႅ])?(ြ)\", \"to\": \"$3$1$2\" }, { \"from\": \"်\", \"to\": \"္\" }, { \"from\": \"ျ\", \"to\": \"်\" }, { \"from\": \"ြ\", \"to\": \"ျ\" }, { \"from\": \"ွ\", \"to\": \"ြ\" }, { \"from\": \"ှ\", \"to\": \"ွ\" }, { \"from\": \"([^်ည])ွ([ိီ]?)ု\", \"to\": \"$1ႈ$2\" }, { \"from\": \"([ရ်ြႊႈ႐])([ူွ])?([ဲံ္ိီႋႌႍႎ]?)(ု)?့\", \"to\": \"$1$2$3$4႕\" }, { \"from\": \"([ုနူွ])([ဲံ္ိီႋႌႍႎ]?)့\", \"to\": \"$1$2႔\" }, { \"from\": \"([ျ])([က-အ])([ႇ]?)([ံိီႋႌႍႎ]?)ု\", \"to\": \"$1$2$3$4ဳ\" }, { \"from\": \"([ျ])([က-အ])([ႇ]?)([ံိီႋႌႍႎ]?)ူ\", \"to\": \"$1$2$3$4ဴ\" }, { \"from\": \"([်ြညဠဥ])([ွ]?)([ံိီႋႌႍႎ]?)ု\", \"to\": \"$1$2$3ဳ\" }, { \"from\": \"([်ြညရ])(ွ?)([ံိီႋႌႍႎ]?)ူ\", \"to\": \"$1$2$3ဴ\" }, { \"from\": \"ညွ\", \"to\": \"ညႇ\" }, { \"from\": \"ွူ\", \"to\": \"ႉ\" }, { \"from\": \"ျ([ကဃဆဏတထဘယလယသဟ])\", \"to\": \"ၾ$1\" }, { \"from\": \"ၾ([ကဃဆဏတထဘယလယသဟ])([ြႊ])([ဲံိီႋႌႍႎ])\", \"to\": \"ႄ$1$2$3\" }, { \"from\": \"ၾ([ကဃဆဏတထဘယလယသဟ])([ြႊ])\", \"to\": \"ႂ$1$2\" }, { \"from\": \"ၾ([ကဃဆဏတထဘယလယသဟ])([ဳဴ]?)([ဲံိီႋႌႍႎ])\", \"to\": \"ႀ$1$2$3\" }, { \"from\": \"ျ([က-အ])([ြႊ])([ဲံိီႋႌႍႎ])\", \"to\": \"ႃ$1$2$3\" }, { \"from\": \"ျ([က-အ])([ြႊ])\", \"to\": \"ႁ$1$2\" }, { \"from\": \"ျ([က-အ])([ဳဴ]?)([ဲံိီႋႌႍႎ])\", \"to\": \"ၿ$1$2$3\" }, { \"from\": \"်ွ\", \"to\": \"ွ်\" }, { \"from\": \"်([ြႊ])\", \"to\": \"$1ၽ\" }, { \"from\": \"([ဳဴ])႔\", \"to\": \"$1႕\" }, {  \"from\": \"ႏၱ\",  \"to\" : \"ႏၲ\" }, {  \"from\": \"([က-အ])([ၻၦ])ာ\",  \"to\": \"$1ာ$2\" }, {  \"from\": \"ာ([ၻၦ])့\",  \"to\": \"ာ$1႔\" }]";
        return replace_with_rule(rule, input);
    }

    public static String replace_with_rule(String rule, String output) {
        try {
            JSONArray rule_array = new JSONArray(rule);
            int max_loop = rule_array.length();
            output = output.replace("null", "\uffff\uffff");

            for(int i = 0; i < max_loop; ++i) {
                JSONObject obj = rule_array.getJSONObject(i);
                String from = obj.getString("from");
                String to = obj.getString("to");
                output = output.replaceAll(from, to);
                output = output.replace("null", "");
            }
        } catch (JSONException var8) {
            var8.printStackTrace();
        }

        output = output.replace("\uffff\uffff", "null");
        return output;
    }
}
