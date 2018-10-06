# RendererToy
A Model-Renderer pool implementation for RecyclerView. dagger required.

The following is implemented:
* Renderer: a unit to create/bind a view from a data model
* RendererAdapter: wire up Renderer with RecyclerView.Adapter logic
* RendererPool: provides a binding from a model class to a renderer
* RendererBindingModule: dagger multi binding to bind class with renderer providers into a map, used in RendererPool

The following is still missing:
* RendererPool#recycleRenderer: note this is not called on RecyclerView's item being scrolled out of screen, it should be called manually when a RecyclerView is removed from screen. See the javadoc for details

To use it:
* Set up a RecyclerView
* define a model and implement a corresponding Renderer
* register the model-renderer pair in RendererBindingModule
* set up a RecyclerViewController with the recyclerView and RendererPool(daggerized)
* use RecyclerViewController#addModel and see magic happen(example in RendererToyActivity)
