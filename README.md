# ViewStubViewPagerMVVM
### Delayed Loading of Views

Sometimes your layout might require complex views that are rarely used. Whether they are item details, progress indicators, or undo messages, you can reduce memory usage and speed up rendering by loading the views only when they are needed.

Deferring loading resources is an important technique to use when you have complex views that your app might need in the future. You can implement this technique by defining a ViewStub for those complex and rarely used views.

### ViewStub

ViewStub is a lightweight view with no dimension that doesn’t draw anything or participate in the layout. As such, it's cheap to inflate and cheap to leave in a view hierarchy. Each ViewStub simply needs to include the android:layout attribute to specify the layout to inflate.

![viewstub](https://user-images.githubusercontent.com/42339771/78687522-e022bf80-7911-11ea-9072-3e7005414374.gif)
