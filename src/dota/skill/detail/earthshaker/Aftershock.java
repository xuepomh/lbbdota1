package dota.skill.detail.earthshaker;

import java.util.List;

import dota.config.generated.SkillCfg;
import dota.hero.Combater;
import dota.skill.Skill;
import dota.team.CombatTeam;

public class Aftershock extends Skill{

	public Aftershock(SkillCfg config) {
		super(config);
	}

	@Override
	protected int emit0(Combater attacker, Combater target) {
		emitBuff(target);
		return 0;
	}

	@Override
	protected void selectTargets0( List<Combater> targets, Combater attacker,
			CombatTeam defenserTeam, CombatTeam attackerTeam) {
		targets.add(attacker);
	}

}
