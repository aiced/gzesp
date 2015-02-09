package com.ai.osapp.dao.persistence;

public interface CommonMapper {
    
  public String getCurrent(String seqname);
  
  public String getNext(String seqname);
  
  public String getLogId(String seqname);
  
}