public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String weaponName, int weaponDamage) {
        super(weaponName, weaponDamage);
    }

    @Override
    public int remainingUses() {
        return 0;
    }

    @Override
    public int remainingAmmo() {
        return remainingUses();
    }

    public String toString() {
        return super.toString() + " " + " Weapon damage: " + getWeaponDamage();
    }
}