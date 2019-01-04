let app = angular.module("ngAnimate", []);
app.controller("bookTableController", function($scope, $http) {
    $http.get("table").then(function(response) {
        $scope.bookTable = response.data;
        $scope.books = $scope.bookTable.records;
        console.log(response.data);
        console.log(typeof $scope.books[0].dateOfPublishing);
    }, function(error) {
        console.log(error);
    });
    $scope.addBook = function(book) {

        if(validateBook(book, $scope.books)) {
            book.dateOfPublishing = {
                year: book.dateOfPublishing.getFullYear(),
                month: book.dateOfPublishing.getMonth() + 1,
                dayOfMonth: book.dateOfPublishing.getDate(),
                hourOfDay: 0,
                minute: 0,
                second: 0
            };
            book.dateOfAdding = {
                year: book.dateOfAdding.getFullYear(),
                month: book.dateOfAdding.getMonth() + 1,
                dayOfMonth: book.dateOfAdding.getDate(),
                hourOfDay: 0,
                minute: 0,
                second: 0
            };
            console.log(book);
            $scope.books.push(book);
            $scope.book = {};
        }
    };
    $scope.removeBook = function(index){
        $scope.books.splice(index,1);
    };

    $('.insert').click(function(){

        //creating "empty" book object for correct working of validation.
        $scope.book={
            id : undefined,
            author : undefined,
            name : undefined,
            pages : undefined,
            dateOfPublishing : undefined,
            dateOfAdding : undefined
        };

        $('.addItems').show( "slow" );
    });
    $('.close').click(function(){
        $('.addItems').hide('slide',{direction:'down'},'slow');
    });
    $('.save-button').click(function () {
        $http.post("save",$scope.bookTable).then(function(response) {
            alert("Table is saved successfully!")
        }, function (error) {
            console.log(error);
        });
    });
    $('.sort-button').click(function () {
        let sort = $('input[name="sort"]:checked').val();
        $http.post("sort",{table : $scope.bookTable, sortColumn : sort}).then(function(response) {
            $scope.bookTable = response.data;
            $scope.books = $scope.bookTable.records;
        }, function (error) {
            console.log(error);
        });
    });
});

function validateBook(book, books) {

    let positiveInteger = /^\+?(0|[1-9]\d*)$/;

    if(!(positiveInteger.test(book.id))) {
        alert("The id is not a positive integer.");
        return false;
    }
    for(let otherBook of books) {
        if(book.id == otherBook.id) {
            alert("This id already exist, try another one.");
            return false;
        }
    }

    //js thinks my pages field in book object is deprecated.
    if(!(positiveInteger.test(book["pages"]))){
        alert("The page is not a positive integer.");
        return false;
    }

    for(let field in book) {
        if(book[field] == undefined) {
            alert("The filed can't be empty.");
            return false;
        }
    }

    return true;
}