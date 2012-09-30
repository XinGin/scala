package scala.reflect
package internal

import scala.language.implicitConversions

trait FlagSets extends api.FlagSets { self: SymbolTable =>

  type FlagSet = Long
  implicit val FlagSetTag = ClassTag[FlagSet](classOf[FlagSet])

  implicit def addFlagOps(left: FlagSet): FlagOps =
    new FlagOpsImpl(left)

  private class FlagOpsImpl(left: Long) extends FlagOps {
    def | (right: Long): Long = left | right
  }

  val NoFlags: FlagSet = 0L

  trait FlagValues extends FlagValuesApi

  object Flag extends FlagValues {
    val TRAIT         : FlagSet = Flags.TRAIT
    val INTERFACE     : FlagSet = Flags.INTERFACE
    val MUTABLE       : FlagSet = Flags.MUTABLE
    val MACRO         : FlagSet = Flags.MACRO
    val DEFERRED      : FlagSet = Flags.DEFERRED
    val ABSTRACT      : FlagSet = Flags.ABSTRACT
    val FINAL         : FlagSet = Flags.FINAL
    val SEALED        : FlagSet = Flags.SEALED
    val IMPLICIT      : FlagSet = Flags.IMPLICIT
    val LAZY          : FlagSet = Flags.LAZY
    val OVERRIDE      : FlagSet = Flags.OVERRIDE
    val PRIVATE       : FlagSet = Flags.PRIVATE
    val PROTECTED     : FlagSet = Flags.PROTECTED
    val LOCAL         : FlagSet = Flags.LOCAL
    val CASE          : FlagSet = Flags.CASE
    val ABSOVERRIDE   : FlagSet = Flags.ABSOVERRIDE
    val BYNAMEPARAM   : FlagSet = Flags.BYNAMEPARAM
    val PARAM         : FlagSet = Flags.PARAM
    val COVARIANT     : FlagSet = Flags.COVARIANT
    val CONTRAVARIANT : FlagSet = Flags.CONTRAVARIANT
    val DEFAULTPARAM  : FlagSet = Flags.DEFAULTPARAM
    val PRESUPER      : FlagSet = Flags.PRESUPER
    val DEFAULTINIT   : FlagSet = Flags.DEFAULTINIT
  }
}
