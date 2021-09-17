package template.java.data;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

import template.java.utils.JsonUtil;
import template.java.utils.jsonsub.JsonToObjUserList;
import template.java.utils.model.Item;
import template.java.utils.model.ItemListDTO;

public class Data_02_JsonParsing {

	public static void main(String[] args) {
		try {
			for (String str : args ) {
				System.out.println("Param : "+str);
			}
			
			JsonUtil ju = JsonUtil.getInstance();

			/**
			 * JSON 객체 1개 -> JsonNode
			 */
			System.out.println("---------- JSON -> JsonNode ----------");
			JsonNode jsonNode = ju.getJsonNode(new File(args[0]));
			System.out.println(jsonNode.toPrettyString());
			System.out.println(jsonNode.get("itemId").asInt());
			System.out.println(jsonNode.get("itemName").asText());
			System.out.println(jsonNode.get("itemPrice").asLong());
			System.out.println(jsonNode.get("sales").asBoolean());
			System.out.println(jsonNode.get("images").isArray());
			System.out.println(jsonNode.get("images").get(2).asText());
			System.out.println(jsonNode.get("stockHistory").get(0).get("receivingDate").asText());
			System.out.println("");
			
			
			/**
			 * JSON 객체 1개 -> Object지정
			 */
			System.out.println("---------- JSON -> Object One ----------");
			Item item = (Item)ju.jsonToObj(new File(args[0]), Item.class);
			System.out.println(item.toString());
			System.out.println("");
			
			
			/**
			 * JSON 리스트 -> List<Map> Object 지정이 없다면 Map에 데이터가 담긴다.
			 */
			System.out.println("---------- JSON List -> List<Map> ----------");
			
			List list = (List)ju.jsonToObj(new File(args[1]), List.class);
			for (Object data : list) {
				System.out.println(data instanceof Map);
				System.out.println(data instanceof Item);
				
				Map map = (Map)data;
			    for (Object keyObj : map.keySet()) {
			    	String key = (String)keyObj;
			    	System.out.println("Key : "+key+", Value : "+map.get(key));
			    }
				
			}
			System.out.println("");
			
			/**
			 * JSON 리스트 -> List<Object지정>
			 */
			System.out.println("---------- JSON List -> List<Object> ----------");
			
			Object obj = ju.jsonListToObjList(new File(args[1]), new JsonToObjUserList());
			List<Item> items = (List<Item>) obj;
			for	(Item itemData : items) {
				System.out.println(itemData.toString());
			}
			
			System.exit(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
