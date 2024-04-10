/**배열로 나열된 숫자를 더해서 평균을 구하는 코드 */

import React, { useState, useCallback, useMemo } from 'react';

function getAverage(nums) {
  console.log('getAgerage함수 호출');
  //합계 / 갯수 = 평균
  const total = nums.reduce((acc, num) => {
    //reduce() 메서드는 배열의 각 요소에 대해 주어진 콜백 함수를 실행하면서 하나의 결과값을 반환
    //acc는 누적값, num은 배열의 현재 요소
    acc += num;
    return acc;
  }, 0); //값이 없을때 초기값 0

  let avg = total / nums.length;

  //소수점 첫째자리까지 표기하고 반올림
  avg = Math.round(avg * 10) / 10;

  return avg;
}

const Average = () => {
  const [nums, setNums] = useState([]); //초기 상태값을 빈 배열로 설정
  //배열 nums -> 사용자가 입력한 숫자들이 담길 배열
  const [num, setNum] = useState(''); //num은 사용자가 현재 입력 중인 숫자

  /**input 요소의 값이 변경될 때 호출되는 이벤트 핸들러
   * input 값의 변화를 감지하여 해당 값을 숫자로 변환하고 상태에 저장
   */
  const onChange = useCallback(
    (e) =>
      setNum(e.currentTarget.value !== isNaN ? Number(e.currentTarget.value) : 0),
    [],
  ); //현재 입력된 값이 NaN이 아니면 해당 값을 숫자로 변환하고, NaN이면 0으로 설정

  /** form 요소가 제출될 때 호출되는 이벤트 핸들러
   *  form 제출 시에 입력된 숫자를 배열에 추가하는 역할
   */
  const onSubmit = useCallback(
    (e) => {
      e.preventDefault();
      setNums((nums) => nums.concat(num)); //배열값 추가할때 결합시키는 역할, 새로운 배열객체로 만들고 추가하는것임
    },
    [num], //이 부분이 변할 때마다 새로운 onSubmit 함수가 생성
  );

  //const avg = getAverage(nums);
  const avg = useMemo(() => getAverage(nums), [nums]); //nums의 값이 변경될때만 호출될 필요가있다.

  return (
    <>
      <form autoComplete="off" onSubmit={onSubmit}>
        <input type="number" value={num} onChange={onChange} />
        <button type="submit">등록</button> {/**등록버튼 누르면 숫자 추가 */}
      </form>
      <ul>
        {' '}
        {/**사용자 입력을 받아들이며, 해당 입력을 화면에 표시하는데 사용 */}
        {/**nums 배열의 각 요소를 순회하며 li태그를 생성한다. num은 배열의 각 요소를 나타내고 i는 각 요소의 인덱스를 나타냄 */}
        {/**사용자가 숫자를 입력하고 등록 버튼을 누르면 nums 배열에 숫자가 추가되고, nums 배열의 각 요소들이 순회되어 리스트 형태로 화면에 표시 */}
        {nums.map((num, i) => (
          <li key={i}>{num}</li>
        ))}
      </ul>
      평균: {avg}
    </>
  );
};

export default React.memo(Average);
