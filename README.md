__TL;NR__

- 
|     | phone rotation | navigating to another screen |
| -------- | ------- | ------- |
| `LaunchedEffect` | cancelled | cancelled  |
| `rememberCoroutineScope()` | cancelled | cancelled |
| `viewModelScope` | Job keeps running until finished | Job keeps running until finished |

- `LaunchedEffect` and `rememberCoroutineScope()` are attached to the composable lifecycle. The jobs will be cancelled if the composable leaves its composition.
- `viewModelScope` is attached to the ViewModel lifecycle. The jobs will be cancelled if the viewModel is cleared.

## Composable Lifecycle

![image](https://github.com/ruiqima/ScopeInvestment/assets/40756115/6e5b47e4-40fc-407c-bea0-0256ad8a2569)

- Configuration changes and navigating to another screen can let the composable leave the composition.
- See [Lifecycle of composables](https://developer.android.com/jetpack/compose/lifecycle).


## ViewModel Lifecycle
- A ViewModel, including the one returned by viewModel(), is scoped to either an Activity or Fragment, not the Composable where viewModel() was called. See [viewModel](https://developer.android.com/reference/kotlin/androidx/lifecycle/viewmodel/compose/package-summary#viewModel(androidx.lifecycle.ViewModelStoreOwner,kotlin.String,kotlin.Function1)).
- See [viewModel](https://developer.android.com/jetpack/compose/libraries#viewmodel) for the following statement.
> Note: Due to their lifecycle and scoping, you should access and call ViewModel instances at screen-level composables,
> that is, close to a root composable called from an activity, fragment, or destination of a Navigation graph.
> You should never pass down ViewModel instances to other composables, pass only the data they need and functions that perform the required logic as parameters.
