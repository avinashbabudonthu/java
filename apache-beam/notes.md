# Apche beam notes

# what is apache beam?
* Latest open source project from apache
* Unified programming model for expressing efficient and portable big data processing pipelines

# Beam basic terminology
* Pipeline
	* Encapsulates entire data processing task from start to end
	* Included reading input data, transforming data, writing output data
	* When we create pipeline we create execute options that tell pipeline where and how to run. This included pipeline runner that determines where this pipeline will run whether it will be `Spark`, `Flink`, 'GCP cloud dataflow` or `local`
* PCollection
	* Equivalent to RDD of Spark
	* Represents distributed data set that our beam pipeline operates on
	* Data set can
		* Bounded: coming from fixed source
		* Unbounded: coming from source which continuously emitting data like Kafka, Pubsub, Stream APIs etc
	* Immutable
		* Applying PTransform (transforming) on PCollection result in creating new PCollection
	* ElementType
		* Elements of PCollection can be of any type but all must in same type
	* Operation Type
		* Does not support grained operations means we cannot apply transformations on some specific elements in PCollection
		* Transformations that we apply will be applied on all elements of PCollection
	* Timestamps
		* Each element in PCollection has an associate timestamp with it
		* Bounded: Every element is set to same timestamp
		* Unbounded: Source assigns the timestamp
* PTransform
	* Represents data processing operation or step in pipeline
	* Takes one or more PCollection as input and perform transformations on each element of PCollection and produces 0 or more PCollection outputs
	* Some examples
		* ParDo
		* Filter
		* Flatten
		* Combine

# Windowing
