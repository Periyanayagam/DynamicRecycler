package com.perusudroid.shree.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class ResponseData{
  @SerializedName("data")
  @Expose
  private List<Data> data;
  public ResponseData(){
  }
  public ResponseData(List<Data> data){
   this.data=data;
  }
  public void setData(List<Data> data){
   this.data=data;
  }
  public List<Data> getData(){
   return data;
  }
}