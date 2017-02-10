package com.ai.gzesp.osn;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Envelope")
public class Envelope {
	
	private Header Header;
	
	private Body Body;

	public Header getHeader() {
		return Header;
	}

	public Body getBody() {
		return Body;
	}

	public void setHeader(Header header) {
		Header = header;
	}

	public void setBody(Body body) {
		Body = body;
	}
	
	

}
