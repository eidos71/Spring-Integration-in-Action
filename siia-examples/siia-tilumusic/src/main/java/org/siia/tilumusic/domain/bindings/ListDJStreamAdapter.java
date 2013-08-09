package org.siia.tilumusic.domain.bindings;

import java.util.ArrayList;


import javax.xml.bind.annotation.adapters.XmlAdapter;


import org.siia.tilumusic.domain.DJStream;

public class ListDJStreamAdapter  extends XmlAdapter<ArrayList<DJStream>, ArrayList<DJStream>>{

	@Override
	public ArrayList<DJStream> unmarshal(ArrayList<DJStream> v) throws Exception {
		System.out.println (v.size());
		return v;
	}

	@Override
	public ArrayList<DJStream> marshal(ArrayList<DJStream> v) throws Exception {
		System.out.println (v.size());
		return v;
	}

}
