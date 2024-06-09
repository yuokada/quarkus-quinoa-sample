package io.github.yuokada.model;

public record TodoDetail(
    long id,
    String title,
    String description,
    boolean done) {

}
