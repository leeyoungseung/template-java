package template.java.utils.jsonsub;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import template.java.utils.model.Item;

public class JsonToObjItemList implements JsonToObj {

	@Override
	public TypeReference<?> getTypeReference() {
		return new TypeReference<List<Item>>(){};
	}

}
