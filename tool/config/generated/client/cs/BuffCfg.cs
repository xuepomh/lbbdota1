// Generated by tool, DO NOT modify!
using ProtoBuf;
namespace HXFS.Config
{
  [ProtoContract]
  public class BuffCfg : CfgBase
  {
    public BuffCfg() {}

    [ProtoMember(1)]
    public override int Id { get; set; } // 索引
    [ProtoMember(2)]
    public string Name { get; set; } // 名字
    [ProtoMember(3)]
    public int BuffType { get; set; } // BUFF类型
    [ProtoMember(4)]
    public int EmitValue { get; set; } // BUFF作用时对应的值
    [ProtoMember(5)]
    public int EmitValue0 { get; set; } // BUFF作用时对应的值0
    [ProtoMember(6)]
    public int EmitTime { get; set; } // 持续时间 MS
    [ProtoMember(7)]
    public int EffectScope { get; set; } // 作用范围
  }
}
