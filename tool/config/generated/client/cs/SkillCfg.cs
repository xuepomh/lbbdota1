// Generated by tool, DO NOT modify!
using ProtoBuf;
namespace HXFS.Config
{
  [ProtoContract]
  public class SkillCfg : CfgBase
  {
    public SkillCfg() {}

    [ProtoMember(1)]
    public override int Id { get; set; } // 索引
    [ProtoMember(2)]
    public string Name { get; set; } // 名字
    [ProtoMember(3)]
    public int SkillType { get; set; } // 技能类型 英雄代号+技能代号
    [ProtoMember(4)]
    public int Cd { get; set; } // 技能冷却 MS
    [ProtoMember(5)]
    public int EmitType { get; set; } // 释放类型，0被动，1主动
    [ProtoMember(6)]
    public int EmitDistance { get; set; } // 施法距离
    [ProtoMember(7)]
    public int EffectScope { get; set; } // 作用范围
    [ProtoMember(8)]
    public int EffectTime { get; set; } // 作用时间 S
    [ProtoMember(9)]
    public int Damage { get; set; } // 伤害
    [ProtoMember(10)]
    public int EnergyCost { get; set; } // 魔法消耗
    [ProtoMember(11)]
    public string Buffs { get; set; } // 产生的BUFF
  }
}
