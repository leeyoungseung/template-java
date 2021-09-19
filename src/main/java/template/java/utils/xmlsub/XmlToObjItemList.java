package template.java.utils.xmlsub;

import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import template.java.utils.model.Item;

public class XmlToObjItemList implements XmlToObj {

	@Override
	public TypeReference<?> getTypeReference() {
		return new TypeReference<List<Item>>(){};
	}

}
