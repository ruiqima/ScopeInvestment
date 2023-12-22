__TL;NR__

- See the table below for how `LaunchedEffect`, `rememberCoroutineScope()`, `viewModelScope` behave differently for job cancellation.

|     | phone rotation | composable leaves the composition |
| -------- | ------- | ------- |
| `LaunchedEffect` | cancelled | cancelled  |
| `rememberCoroutineScope()` | cancelled | cancelled |
| `viewModelScope` | Job keeps running until finished | Job keeps running until finished |

- It is a good practice (not mandatory) to keep ViewModel free from Android framework references like Activity, Context, etc.

## How they behave differently
- Launching coroutines in `rememberCoroutineScope()` from a composable behaves differently compared to launching them in `viewModelScope` from a ViewModel. 
  
 

## Why they behave differently
- The key distinction is that `coroutineScope` is tied to the lifecycle of the composable, while `viewModelScope` is tied to the lifecycle of the ViewModel.
- The ViewModel's lifecycle is similar to that of an `Activity`, which is separate from the lifecycle of the composable where the ViewModel is initialized.
