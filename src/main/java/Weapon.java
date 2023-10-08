public abstract class Weapon extends Item {

    private int weaponDamage;

    public Weapon(String weaponName, int weaponDamage) {
        super(weaponName);
        this.weaponDamage = weaponDamage;
    }

    public abstract int remainingUses();

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public abstract int remainingAmmo();

    public String toString() {
        return getItemName() + " " + weaponDamage + " ";
    }
}
