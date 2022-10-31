package com.kodilla.rps;

public class Scissors implements Weapons{
    private final String weaponName = "Scissors";
    public char fight (Weapons weapon){
        if (weapon.getWeaponName().equals("Paper")){
            return 'w';
        } else if (weapon.getWeaponName().equals(weaponName)) {
            return 't';
        } else if (weapon.getWeaponName().equals("Rock")) {
            return 'l';
        }
        return 'e';
    }
    public String getWeaponName() {
        return weaponName;
    }
}
