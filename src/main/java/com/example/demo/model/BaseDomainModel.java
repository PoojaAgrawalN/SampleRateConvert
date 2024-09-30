package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * A base class for domain models that includes common fields and functionality.
 * This class is intended to be used as a superclass for other domain models
 * that require a creation timestamp.
 */
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseDomainModel {

    private LocalDateTime createdAt;
}
