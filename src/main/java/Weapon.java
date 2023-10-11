public abstract class Weapon extends Item {

    private int weaponDamage;

    public Weapon(String weaponName, int weaponDamage) {
        super(weaponName);
        this.weaponDamage = weaponDamage;
    }

    public abstract int remainingUses();

    public abstract boolean canUse();

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public abstract int remainingAmmo();


}