//package ml.combust.mleap.bundle.ops.feature
//
//import ml.combust.bundle.BundleContext
//import ml.combust.bundle.dsl._
//import ml.combust.bundle.op.{OpModel, OpNode}
//import ml.combust.mleap.runtime.MleapContext
//import ml.combust.mleap.runtime.transformer.feature.CachedIdentityTransformer
//
///**
//  * Created by mageswarand on 14/2/17.
//  */
//class CachedIdentityTransformerOp extends OpNode[MleapContext, CachedIdentityTransformer, CachedIdentityTransformer] {
//
//  override val Model: OpModel[MleapContext, CachedIdentityTransformer] = new OpModel[MleapContext, CachedIdentityTransformer] {
//    // the class of the model is needed for when we go to serialize JVM objects
//    override val klazz: Class[CachedIdentityTransformer] = classOf[CachedIdentityTransformer]
//
//    // a unique name for our op
//    override def opName: String = "identity_transformer"
//
//    override def store(model: Model, obj: CachedIdentityTransformer)(implicit context: BundleContext[MleapContext]): Model = {
//      model
//    }
//
//    override def load(model: Model)(implicit context: BundleContext[MleapContext]): CachedIdentityTransformer = {
//      CachedIdentityTransformer(uid = "",
//      "features",
//      "features_dummy")
//    }
//  }
//
//  // class of the transformer
//  override val klazz: Class[CachedIdentityTransformer] = classOf[CachedIdentityTransformer]
//
//  // unique name in the pipeline for this transformer
//  override def name(node: CachedIdentityTransformer): String = node.uid
//
//  // the core model that is used by the transformer
//  override def model(node: CachedIdentityTransformer): CachedIdentityTransformer = node
//
//
//  // the shape defines the inputs and outputs of our node
//  // in this case, we have 1 input and 1 output that
//  // are connected to the standard input and output ports for
//  // a node. shapes can get fairly complicated and may be confusing at first
//  // but all they do is connect fields from a data frame to certain input/output
//  // locations of the node itself
//  override def shape(node: CachedIdentityTransformer): Shape =
//  Shape().withStandardIO(node.inputCol, node.outputCol)
//
//  // reconstruct our MLeap transformer from the
//  // deserialized core model, unique name of this node,
//  // and the inputs/outputs of the node
//  override def load(node: Node, model: CachedIdentityTransformer)(implicit context: BundleContext[MleapContext]): CachedIdentityTransformer = {
//
//    CachedIdentityTransformer(uid = node.name,
//      inputCol = node.shape.standardInput.name,
//      outputCol = node.shape.standardOutput.name)
//  }
//}
