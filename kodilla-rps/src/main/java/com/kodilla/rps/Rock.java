package com.kodilla.rps;

public final class Rock implements Weapons{
    private final String weaponName = "Rock";
    public char fight (Weapons weapon){
        if (weapon.getWeaponName().equals("Scissors")){
            return 'w';
        } else if (weapon.getWeaponName().equals(weaponName)) {
            return 't';
        } else if (weapon.getWeaponName().equals("Paper")) {
            return 'l';
        }
        return 'e';
    }
    public String getWeaponName() {
        return weaponName;
    }
}
