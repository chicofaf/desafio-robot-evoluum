package com.mars.api.exploration;

import java.util.HashMap;
import java.util.Map;

public class DirectionRules {
    public static Map<String, Map<String, String>> RULES = new HashMap<String, Map<String, String>>(){{
        put("N",new HashMap<String, String>(){{
            put("L","W");
            put("R","E");
        }});
        put("S",new HashMap<String, String>(){{
            put("L","E");
            put("R","W");
        }});
        put("W",new HashMap<String, String>(){{
            put("L","S");
            put("R","N");
        }});
        put("E",new HashMap<String, String>(){{
            put("L","N");
            put("R","S");
        }});
    }};
}
