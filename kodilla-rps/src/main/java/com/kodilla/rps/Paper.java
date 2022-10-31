package com.kodilla.rps;

public class Paper implements Weapons{
    private final String weaponName = "Paper";
    public char fight (Weapons weapon){
        if (weapon.getWeaponName().equals("Rock")){
            return 'w';
        } else if (weapon.getWeaponName().equals(weaponName)) {
            return 't';
        } else if (weapon.getWeaponName().equals("Scissors")) {
            return 'l';
        }
        return 'e';
    }
    public String getWeaponName() {
        return weaponName;
    }
}
