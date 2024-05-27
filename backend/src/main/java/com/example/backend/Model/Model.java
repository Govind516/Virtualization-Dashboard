package com.example.backend.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "data")
public class Model {

  @Id
  @Field("_id")
  private ObjectId id; // MongoDB will use this field as the document ID

  private int intensity;
  private int likelihood;
  private int relevance;
  private int end_year;
  private int start_year;
  private int impact;
  private String sector;
  private String topic;
  private String insights;
  private String url;
  private String region;
  private String added;
  private String published;
  private String country;
  private String postle;
  private String source;
  private String title;

  // Constructor with parameters
  public Model(int intensity, int likelihood, int relevance, int end_year,
               String sector, String topic, String insights, String url,
               String region, int start_year, int impact, String added,
               String published, String country, String postle, String source,
               String title) {
    this.intensity = intensity;
    this.likelihood = likelihood;
    this.relevance = relevance;
    this.end_year = end_year;
    this.sector = sector;
    this.topic = topic;
    this.insights = insights;
    this.url = url;
    this.region = region;
    this.start_year = start_year;
    this.impact = impact;
    this.added = added;
    this.published = published;
    this.country = country;
    this.postle = postle;
    this.source = source;
    this.title = title;
  }

  // Getters and Setters
  public ObjectId getId() { return id; }
  public void setId(ObjectId id) { this.id = id; }

  public int getIntensity() { return intensity; }
  public void setIntensity(int intensity) { this.intensity = intensity; }

  public int getLikelihood() { return likelihood; }
  public void setLikelihood(int likelihood) { this.likelihood = likelihood; }

  public int getRelevance() { return relevance; }
  public void setRelevance(int relevance) { this.relevance = relevance; }

  public int getEnd_year() { return end_year; }
  public void setEnd_year(int end_year) { this.end_year = end_year; }

  public String getSector() { return sector; }
  public void setSector(String sector) { this.sector = sector; }

  public String getTopic() { return topic; }
  public void setTopic(String topic) { this.topic = topic; }

  public String getInsights() { return insights; }
  public void setInsights(String insights) { this.insights = insights; }

  public String getUrl() { return url; }
  public void setUrl(String url) { this.url = url; }

  public String getRegion() { return region; }
  public void setRegion(String region) { this.region = region; }

  public int getStart_year() { return start_year; }
  public void setStart_year(int start_year) { this.start_year = start_year; }

  public int getImpact() { return impact; }
  public void setImpact(int impact) { this.impact = impact; }

  public String getAdded() { return added; }
  public void setAdded(String added) { this.added = added; }

  public String getPublished() { return published; }
  public void setPublished(String published) { this.published = published; }

  public String getCountry() { return country; }
  public void setCountry(String country) { this.country = country; }

  public String getPostle() { return postle; }
  public void setPostle(String postle) { this.postle = postle; }

  public String getSource() { return source; }
  public void setSource(String source) { this.source = source; }

  public String getTitle() { return title; }
  public void setTitle(String title) { this.title = title; }
}
