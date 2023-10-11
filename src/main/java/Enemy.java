
public class Enemy {

    private String enemyName;
    private int enemyHealth;
    private Weapon enemyWeapon;

    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }

    public Enemy(String enemyName, int enemyHealth, Weapon enemyWeapon) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyWeapon = enemyWeapon;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public Weapon getEnemyWeapon() {
        return enemyWeapon;
    }

    @Override
    public String toString() {
        return "Enemy:" +
                enemyName +
                ", Health:" + enemyHealth +
                ", Weapon:" + enemyWeapon;
    }

}




