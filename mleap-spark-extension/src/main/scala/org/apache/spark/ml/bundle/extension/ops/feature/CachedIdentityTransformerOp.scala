//package org.apache.spark.ml.bundle.extension.ops.feature
//
//import ml.combust.bundle.BundleContext
//import ml.combust.bundle.dsl.{Model, Node, Shape}
//import ml.combust.bundle.op.{OpModel, OpNode}
//import org.apache.spark.ml.bundle.SparkBundleContext
//import org.apache.spark.ml.mleap.feature.CachedIdentityTransformer
//
///**
//  * Created by mageswarand on 14/2/17.
//  */
//
//class CachedIdentityTransformerOp extends OpNode[SparkBundleContext, CachedIdentityTransformer, CachedIdentityTransformer] {
//  override val Model: OpModel[SparkBundleContext, CachedIdentityTransformer] = new OpModel[SparkBundleContext, CachedIdentityTransformer] {
//    override val klazz: Class[CachedIdentityTransformer] = classOf[CachedIdentityTransformer]
//
//    override def opName: String = "identity_transformer"
//
//    override def store(model: Model, obj: CachedIdentityTransformer)(implicit context: BundleContext[SparkBundleContext]): Model =
//      model
//
//    override def load(model: Model)(implicit context: BundleContext[SparkBundleContext]): CachedIdentityTransformer =
//      new CachedIdentityTransformer()
//  }
//  override val klazz: Class[CachedIdentityTransformer] = classOf[CachedIdentityTransformer]
//
//  override def name(node: CachedIdentityTransformer): String = node.uid
//
//  override def model(node: CachedIdentityTransformer): CachedIdentityTransformer = node
//
//  override def shape(node: CachedIdentityTransformer): Shape = Shape().withStandardIO("features", //a dummy assumptiom where feature column is gonna be cached
//      "features_dummy")
//
//  override def load(node: Node, model: CachedIdentityTransformer)(implicit context: BundleContext[SparkBundleContext]): CachedIdentityTransformer = {
//    new CachedIdentityTransformer(node.name)
//  }
//}