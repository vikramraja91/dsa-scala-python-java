from dsa.sorting import bubble_sort


def test_bubble_sort():
    x = [5, 3, 8, 4, 2]

    bubble_sort(x)

    assert x == [2, 3, 4, 5, 8]

