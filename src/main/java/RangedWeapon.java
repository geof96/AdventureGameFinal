public class RangedWeapon extends Weapon {
    private int weaponAmmo;

    public RangedWeapon(String weaponName, int weaponDamage, int weaponAmmo) {
        super(weaponName, weaponDamage);
        this.weaponAmmo = weaponAmmo;
    }

    @Override
    public int remainingUses() {
        return weaponAmmo;
    }

    @Override
    public boolean canUse() {
        if (remainingAmmo() == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public int remainingAmmo() {
        return weaponAmmo--;
    }

    public String toString() {
        return super.toString() + " " + " Weapon damage: " + getWeaponDamage() + ", " + " Weapon ammo: " + weaponAmmo;
    }
}