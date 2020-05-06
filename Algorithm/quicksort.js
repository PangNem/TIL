
function solution() {
  var array = [20, 18, 50, 40, 9, 19, 5, 25];

  quicksort(array, 0, array.length - 1);

  // console.log(array);
}

function quicksort(arr, left, right) {
  if (left >= right) {
    // console.log(arr);
    return;
  }
  // var mid = (left + right) / 2;

  var pivot = arr[left];
  var leftPoint = left;
  var rightPoint = right;

  while (leftPoint < rightPoint) {
    while (pivot < arr[leftPoint]) {
      leftPoint++;
    }

    while (leftPoint < rightPoint && pivot >= arr[leftPoint]) {
      rightPoint--;
    }
    // swap(arr, leftPoint, rightPoint);

    var temp = arr[rightPoint];
    arr[rightPoint] = arr[leftPoint];
    arr[leftPoint] = temp;

  }

  arr[left] = arr[leftPoint];
  arr[leftPoint] = pivot;

  console.log(arr);
  quicksort(arr, left, leftPoint - 1);
  quicksort(arr, leftPoint + 1, right);
}

function swap(arr, a, b) {
  var temp = arr[b];
  arr[a] = arr[b];
  arr[b] = temp;
}

solution(

);