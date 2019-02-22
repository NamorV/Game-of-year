import org.junit.Test;
import rpg.Unit;

import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest {
    private Unit unit1;
    private Unit unit2;

    @Test
    public void whenAttackEnemyHealthReduce() {
        unit1 = new Unit("Horus");
        unit2 = new Unit("Set");
        final int beforeAttack = unit2.getHealth();
        final int afterAttack;

        unit2 = unit1.attack(unit2);
        afterAttack = unit2.getHealth();

        assertThat(beforeAttack).isGreaterThan(afterAttack);
    }

    @Test
    public void whenAttackActionEnemyHealthReduce() {
        unit1 = new Unit("Horus");
        unit2 = new Unit("Set");
        final int beforeAttack = unit2.getHealth();
        final int afterAttack;

        unit2 = unit1.makeAction(1, unit2);
        afterAttack = unit2.getHealth();

        assertThat(beforeAttack).isGreaterThan(afterAttack);
    }
}
