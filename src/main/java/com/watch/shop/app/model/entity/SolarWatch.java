package com.watch.shop.app.model.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.time.Duration;

@Data
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
public class SolarWatch extends Watch {
    private Duration maxChargeTime;
}
