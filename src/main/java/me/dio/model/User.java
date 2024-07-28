package me.dio.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @OneToOne
    @Cascade(CascadeType.ALL) // Strong relationship
    private Account account;
    @OneToMany
    @Cascade(CascadeType.ALL) // Strong relationship
    private List<Feature> features;
    @OneToOne
    @Cascade(CascadeType.ALL) // Strong relationship
    private Card card;
    @OneToMany
    @Cascade({CascadeType.ALL}) // Strong relationship
    private List<News> news;

    public User(Integer id, String name, Account account, List<Feature> features, Card card, List<News> news) {
        this.id = id;
        this.name = name;
        this.account = account;
        this.features = features;
        this.card = card;
        this.news = news;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }
}
