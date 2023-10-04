public class RangedWeapon extends Weapon {
    private int weaponAmmo;

    public RangedWeapon(String weaponName, int weaponDamage, int weaponAmmo) {
        super(weaponName, weaponDamage);
        this.weaponAmmo = weaponAmmo;
    }

    public int getWeaponAmmo() {
        return weaponAmmo;
    }

    @Override
    public int remainingUses() {
        return weaponAmmo;
    }

    public String toString() {
        return super.toString() + " " + " Weapon damage: " + getWeaponDamage() + ", " + " Weapon ammo: " + weaponAmmo;
    }
}
