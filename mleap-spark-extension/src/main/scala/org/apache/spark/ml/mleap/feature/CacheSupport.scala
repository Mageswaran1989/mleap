//package org.apache.spark.ml.mleap.feature
//
//import org.apache.spark.annotation.{DeveloperApi, Since}
//import org.apache.spark.ml.Transformer
//import org.apache.spark.ml.param._
//import org.apache.spark.ml.util._
//import org.apache.spark.sql.types._
//import org.apache.spark.sql.{DataFrame, Dataset}
//
///**
//  * Created by sachint on 14/3/17.
//  */
//trait CacheSupport extends Transformer with Params {
//  final val cachedCols: Param[Seq[String]] = new Param[Seq[String]](this, "outputCols", "cached output column names")
//  private var cachedDF: Option[DataFrame] = None
//
//  abstract override def transform(dataset: Dataset[_]): DataFrame = {
//    val ds = super.transform(dataset)
//    val cols = get(cachedCols).getOrElse(Seq.empty)
//    cachedDF = Option {
//      cols.isEmpty match {
//        case true => ds.toDF.cache()
//        case false => ds.toDF.selectExpr(cols: _*).cache()
//      }
//    }
//    cachedDF.get
//  }
//
//  abstract override def transformSchema(schema: StructType): StructType = {
//    val superSchema = super.transformSchema(schema)
//    val cols = get(cachedCols).getOrElse(Seq.empty)
//    cols.isEmpty match {
//      case true => superSchema
//      case false => StructType(superSchema.filter(s => cols.contains(s.name)))
//    }
//  }
//
//  def getCachedDF(): Option[DataFrame] = {
//    cachedDF
//  }
//
//  def getCachedCols: Array[String] = $(cachedCols).toArray
//
//  def setCachedCols(value: String*): this.type = set(cachedCols, value)
//}
//
//class IdentityTransformer(override val uid: String) extends Transformer with Params {
//  @Since("2.0.0")
//  override def transform(dataset: Dataset[_]): DataFrame = dataset.toDF()
//
//  override def copy(extra: ParamMap): Transformer = defaultCopy(extra)
//
//  @DeveloperApi
//  override def transformSchema(schema: StructType): StructType = schema
//
//  def this() = this(Identifiable.randomUID("identity"))
//}
//
//class CachedIdentityTransformer(override val uid: String = Identifiable.randomUID("identity_transformer")) extends IdentityTransformer with CacheSupport
//
//object CachedIdentityTransformer {
//  def apply(uid: String = Identifiable.randomUID("identity_transformer")): CachedIdentityTransformer = new CachedIdentityTransformer(uid)
//}