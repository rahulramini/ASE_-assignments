var SentimentApp = angular.module("MashApp",[]);


SentimentApp.controller("Sentiment", function ($scope, $http) {
    $scope.mostRecentReview;
    var i,SentimentText;

    $scope.getReviews = function (sentiText) {

        //This is the Alchemy API for getting the sentiment of the most recent review for a place.
        var con = $http.get("http://bechdeltest.com/api/v1/getMoviesByTitle?title=" + sentiText);
        con.success(function (data) {
            if(data!=null)
            {
             //  for(i in data)
             //   {
                    SentimentText = data.title;
             //   SentimentText = console.log(data);
             //   }
                $scope.sentiment1 = data;
            }
        })
    }

});