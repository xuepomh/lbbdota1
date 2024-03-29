package dota.skill.detail.earthshaker;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.enums.Enums;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;
import dota.util.HeroHelper;
import dota.util.OP;

// 回音击
@OP(CODE = Enums.SkillType.ECHO_SLAM_VALUE, TYPE = OP.SKILL)
public class EchoSlam extends Skill {
	
	private int damage = 0;
	
	public EchoSlam(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target, CombatTeam attackTeam, CombatTeam defenseTeam) {
		target.beAttack(damage, Enums.AttackType.MAGICAL_VALUE, attacker);
		System.out.println(attacker.getName() + " 的回音击对 " + target.getName() + " 造成 " + damage + " 的伤害");
		return damage;
	}

	@Override
	protected void selectTargets0(List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		for (Combater e: defenserTeam) {
			if (e.isLive() && HeroHelper.getDistanceBetweenCombaters(attacker, e) <= config.getEffectScope()) {
				targets.add(e);
			}
		}
		damage = config.getDamage() + config.getDamagePara1() * targets.size();
	}

}
