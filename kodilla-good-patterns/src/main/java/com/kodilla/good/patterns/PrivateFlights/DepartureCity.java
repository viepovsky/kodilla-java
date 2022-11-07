package com.kodilla.good.patterns.PrivateFlights;

import java.util.Objects;

record DepartureCity(String departureCity) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartureCity that = (DepartureCity) o;

        return departureCity.equals(that.departureCity);
    }
    @Override
    public int hashCode() {
        return Objects.hash(departureCity);
    }
}
