// bruteforce
int maxi = Integer.MIN_VALUE;
for(0 to n){
	for(j=i to n){
		int sum = 0
		for(k=i to k<=j){
			sum = arr[k];
		}
		maxi = Math.max(maxi, sum);
	}
	return maxi;
}

// better
int maxi = Integer.MIN_VALUE;
for( 0 to n){
	int sum = 0;
	for(j=i to n){
		sum = sum + arr[j];
		maxi = Math.max(maxi, sum);
	}
	return maxi;
}

// optimal sol
for(0 to n){
	int sum = 0;
	int maxi = Integer.MAX_VALUE;
	sum = sum + arr[i];
	if(sum>maxi)
		maxi = sum;
	if(sum<0) // empty subarr
		sum=0;
	return maxi;
}
