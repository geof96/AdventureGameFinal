public class Enemy {

    private String enemyName;
    private int enemyHealth;
    private int enemyDamage;
    private String enemyWeapon;

    public Enemy(String enemyName, int enemyHealth, int enemyDamage, String enemyWeapon) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyDamage = enemyDamage;
        this.enemyWeapon = enemyWeapon;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public String getEnemyWeapon() {
        return enemyWeapon;
    }

    @Override
    public String toString() {
        return "Enemy{" +
                "enemyName='" + enemyName + '\'' +
                ", enemyHealth=" + enemyHealth +
                ", enemyDamage=" + enemyDamage +
                ", enemyWeapon='" + enemyWeapon + '\'' +
                '}';
    }
}