//package ml.combust.mleap.runtime.transformer.feature
//
//import ml.combust.mleap.runtime.function.UserDefinedFunction
//import ml.combust.mleap.runtime.transformer.{FeatureTransformer, Transformer}
//import ml.combust.mleap.tensor.SparseTensor
///**
//  * Created by mageswarand on 14/2/17.
//  */
//
//case class CachedIdentityTransformer(override val uid: String = Transformer.uniqueName("identity_transformer"),
//                            override val inputCol: String,
//                            override val outputCol: String) extends FeatureTransformer {
//  override val exec: UserDefinedFunction = (features: SparseTensor[Double]) => features //just copy
//}
