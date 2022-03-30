# 구구단 프로그래밍

loop do
    puts "===================="
    puts "구구단 프로그램입니다."
    puts "1. 구구단 전체 출력"
    puts "2. 입력 받은 구구단 출력"
    puts "3. 종료"

    printf ">> "
    select1 = gets.chomp

    if select1 == '1'
        for i in 2..9
            puts "================="
            for j in 1..9
                puts "#{i} X #{j} = #{i*j}"
            end
        end

    elsif select1 == '2'
        printf "원하는 구구단의 숫자를 입력하세요  "
        select2 = gets.chomp.to_i
        if 1 < select2 && select2 <10
            puts "=================="
            for j in 1..9
                puts "#{select2} X #{j} = #{select2*j}"
            end
        else
            puts "숫자가 너무 크거나 작습니다."
        end

    elsif select1 == '3'
        puts "프로그램이 종료됩니다."
        break

    else
        puts "잘못된 입력입니다."
    end
end
