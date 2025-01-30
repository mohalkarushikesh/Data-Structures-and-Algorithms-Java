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

// optimal sol/Kadane's Algorithm
for(0 to n){
	int sum = 0;
	int maxi = Integer.MIN_VALUE;
	sum = sum + arr[i];
	if(sum>maxi)
		maxi = sum;
	if(sum<0) // empty subarr
		sum=0;
	return maxi;
}

// print max subarray use Kadane's Algorithm
for(0 to n)
	int sum=0;
	int maxi = Integer.MIN_VALUE;
	int arrstart = -1;
	int arrend = -1;
	int start = 0;
	if(sum==0)
		start=i;
	sum = sum + arr[i];
	if(sum>maxi){
		maxi=sum;
		arrstart = start;
		arrend=i;
	}
	if(sum<0)
		sum=0;
	sout("max subarr srt idx "+ arrstart + " end idx " + arrend);
	return maxi;
